// Demo 10 - an array of references: every element is null until assigned.
// Run: bash ../run.sh Demo10
public class Demo10 {
	public static void main(String[] args) {
		Box10[] br=new Box10[3]; //Reference array, Box10 type
		System.out.println(br[0]+" "+br[1]+" "+br[2]); //null null null
		int[] lengths = {12, 120, 1};
		int[] widths = {5, 50, 2};
		int[] heights = {3, 30, 3};
		int j = 0;
		while (j < br.length) {
			br[j] = new Box10(lengths[j], widths[j], heights[j]);
			j++;
		}

		int i = 0;
		while (i < br.length) {
			System.out.println(br[i].getLength() + " " + br[i].getWidth() + " " + br[i].getHeight());
			i++;
		}
	}
}