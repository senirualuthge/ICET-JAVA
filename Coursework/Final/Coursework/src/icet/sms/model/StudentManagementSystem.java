package icet.sms.model;

import icet.sms.util.JsonUtil;
import java.io.IOException;
import java.nio.file.*;
import java.util.*;
import java.util.stream.*;

public class StudentManagementSystem {
    private final Map<String, Student> studentsByRegNo = new HashMap<>();
    private final Map<String, Student> studentsByNic = new HashMap<>();
    private final Map<Integer, Batch> batches = new HashMap<>();
    private final Map<Integer, List<Student>> studentsByBatch = new HashMap<>();

    private final Map<Integer, Integer> prCounters = new HashMap<>();
    private final Map<Integer, Integer> orCounters = new HashMap<>();

    private static final String DATA_FILE = System.getProperty("user.home") +
        "/icet_sms_data.json";

    public List<Batch> getAllBatches() {
        List<Batch> result = new ArrayList<>(batches.values());
        result.sort(Comparator.comparingInt(Batch::getBatchId));
        return result;
    }

    public boolean batchExists(int batchId) {
        return batches.containsKey(batchId);
    }

    public Batch getBatch(int batchId) {
        return batches.get(batchId);
    }

    public Batch addBatch(int batchId) {
        if (batches.containsKey(batchId)) return null;
        Batch b = new Batch(batchId);
        batches.put(batchId, b);
        studentsByBatch.put(batchId, new ArrayList<>());
        prCounters.put(batchId, 0);
        orCounters.put(batchId, 0);
        return b;
    }

    public boolean updateBatchStatus(int batchId, int status) {
        Batch b = batches.get(batchId);
        if (b == null) return false;
        b.setStatus(status);
        return true;
    }

    public int getStudentCountForBatch(int batchId) {
        List<Student> list = studentsByBatch.get(batchId);
        return list == null ? 0 : list.size();
    }

    public Student getStudentByRegNo(String regNo) {
        return studentsByRegNo.get(regNo);
    }

    public Student getStudentByNic(String nic) {
        return studentsByNic.get(nic);
    }

    public boolean studentExistsByRegNo(String regNo) {
        return studentsByRegNo.containsKey(regNo);
    }

    public boolean studentExistsByNic(String nic) {
        return studentsByNic.containsKey(nic);
    }

    public String generateRegNo(int batchId, boolean isPhysical) {
        Map<Integer, Integer> counters = isPhysical ? prCounters : orCounters;
        int count = counters.getOrDefault(batchId, 0) + 1;
        counters.put(batchId, count);
        String prefix = isPhysical ? "PR" : "OR";
        String seq = String.format("%02d", count);
        String batchStr = String.format("%06d", batchId);
        return prefix + batchStr + seq;
    }

    public Student addStudent(String name, String nic, int prfMarks,
                              int dbmsMarks, int batchId, boolean isPhysical) {
        if (studentsByNic.containsKey(nic)) return null;
        String regNo = generateRegNo(batchId, isPhysical);
        Student s = new Student(regNo, name, nic, prfMarks, dbmsMarks, batchId);
        studentsByRegNo.put(regNo, s);
        studentsByNic.put(nic, s);
        studentsByBatch.get(batchId).add(s);
        return s;
    }

    public boolean updateStudent(String regNo, String newName, String newNic) {
        Student s = studentsByRegNo.get(regNo);
        if (s == null) return false;
        if (!newNic.equals(s.getNic()) && studentsByNic.containsKey(newNic)) return false;
        studentsByNic.remove(s.getNic());
        s.setName(newName);
        s.setNic(newNic);
        studentsByNic.put(newNic, s);
        return true;
    }

    public boolean deleteStudent(String regNo) {
        Student s = studentsByRegNo.get(regNo);
        if (s == null) return false;
        studentsByNic.remove(s.getNic());
        studentsByRegNo.remove(regNo);
        List<Student> list = studentsByBatch.get(s.getBatchId());
        if (list != null) list.remove(s);
        return true;
    }

    public boolean updateMarks(String regNo, int prfMarks, int dbmsMarks) {
        Student s = studentsByRegNo.get(regNo);
        if (s == null) return false;
        s.setPrfMarks(prfMarks);
        s.setDbmsMarks(dbmsMarks);
        return true;
    }

    public boolean updatePrfMarks(String regNo, int prfMarks) {
        Student s = studentsByRegNo.get(regNo);
        if (s == null) return false;
        s.setPrfMarks(prfMarks);
        return true;
    }

    public boolean updateDbmsMarks(String regNo, int dbmsMarks) {
        Student s = studentsByRegNo.get(regNo);
        if (s == null) return false;
        s.setDbmsMarks(dbmsMarks);
        return true;
    }

    public List<Student> getAllStudents() {
        return new ArrayList<>(studentsByRegNo.values());
    }

    public List<Student> getStudentsForBatch(int batchId) {
        List<Student> list = studentsByBatch.get(batchId);
        return list == null ? new ArrayList<>() : new ArrayList<>(list);
    }

    public List<Student> getStudentsEligibleForIndustryTraining() {
        return getAllStudents().stream()
                .filter(Student::isEligibleForIndustryTraining)
                .collect(Collectors.toList());
    }

    public List<Student> getStudentsSortedByName() {
        List<Student> list = getAllStudents();
        list.sort(Comparator.comparing(Student::getName, String.CASE_INSENSITIVE_ORDER));
        return list;
    }

    // ---- Persistence ----

    public void save() {
        try {
            Map<String, Object> root = new LinkedHashMap<>();

            List<Map<String, Object>> batchList = new ArrayList<>();
            for (Batch b : getAllBatches()) {
                Map<String, Object> bm = new LinkedHashMap<>();
                bm.put("batchId", b.getBatchId());
                bm.put("batchName", b.getBatchName());
                bm.put("status", b.getStatus());
                batchList.add(bm);
            }
            root.put("batches", batchList);

            List<Map<String, Object>> studentList = new ArrayList<>();
            for (Student s : getAllStudents()) {
                Map<String, Object> sm = new LinkedHashMap<>();
                sm.put("registrationNo", s.getRegistrationNo());
                sm.put("name", s.getName());
                sm.put("nic", s.getNic());
                sm.put("prfMarks", s.getPrfMarks());
                sm.put("dbmsMarks", s.getDbmsMarks());
                sm.put("batchId", s.getBatchId());
                studentList.add(sm);
            }
            root.put("students", studentList);

            Map<String, Object> counters = new LinkedHashMap<>();
            for (Map.Entry<Integer, Integer> e : prCounters.entrySet()) {
                if (e.getValue() > 0) counters.put("pr:" + e.getKey(), e.getValue());
            }
            for (Map.Entry<Integer, Integer> e : orCounters.entrySet()) {
                if (e.getValue() > 0) counters.put("or:" + e.getKey(), e.getValue());
            }
            root.put("counters", counters);

            JsonUtil.writeFile(DATA_FILE, JsonUtil.toJson(root));
        } catch (IOException e) {
            // silently ignore — persistence is non-critical
        }
    }

    public void load() {
        Path p = Paths.get(DATA_FILE);
        if (!Files.exists(p)) return;
        try {
            String json = JsonUtil.readFile(DATA_FILE);
            Map<String, Object> root = JsonUtil.parse(json);

            // Batches
            List<Map<String, Object>> batchList = (List<Map<String, Object>>) root.get("batches");
            if (batchList != null) {
                for (Map<String, Object> bm : batchList) {
                    int bid = ((Number) bm.get("batchId")).intValue();
                    int status = ((Number) bm.get("status")).intValue();
                    Batch b = new Batch(bid);
                    b.setStatus(status);
                    batches.put(bid, b);
                    studentsByBatch.put(bid, new ArrayList<>());
                    prCounters.put(bid, 0);
                    orCounters.put(bid, 0);
                }
            }

            // Counters
            Map<String, Object> ctrMap = (Map<String, Object>) root.get("counters");
            if (ctrMap != null) {
                for (Map.Entry<String, Object> e : ctrMap.entrySet()) {
                    String k = e.getKey();
                    int v = ((Number) e.getValue()).intValue();
                    if (k.startsWith("pr:")) {
                        prCounters.put(Integer.parseInt(k.substring(3)), v);
                    } else if (k.startsWith("or:")) {
                        orCounters.put(Integer.parseInt(k.substring(3)), v);
                    }
                }
            }

            // Students
            List<Map<String, Object>> studentList = (List<Map<String, Object>>) root.get("students");
            if (studentList != null) {
                for (Map<String, Object> sm : studentList) {
                    String regNo = (String) sm.get("registrationNo");
                    String name = (String) sm.get("name");
                    String nic = (String) sm.get("nic");
                    int prf = ((Number) sm.get("prfMarks")).intValue();
                    int dbms = ((Number) sm.get("dbmsMarks")).intValue();
                    int bid = ((Number) sm.get("batchId")).intValue();
                    Student s = new Student(regNo, name, nic, prf, dbms, bid);
                    studentsByRegNo.put(regNo, s);
                    studentsByNic.put(nic, s);
                    studentsByBatch.get(bid).add(s);
                }
            }
        } catch (Exception e) {
            // if file is corrupt, start fresh
        }
    }
}
