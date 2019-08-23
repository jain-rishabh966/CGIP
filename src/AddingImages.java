import java.util.Scanner;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.highgui.HighGui;
import org.opencv.imgcodecs.Imgcodecs;

public class AddingImages {
	public AddingImages() {
		double w = 0.5;
		double i;

		Mat src1, src2, dest = new Mat();
		System.out.println("Enter weight between 0.0 and 1.0: ");
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		i = scan.nextDouble();

		if (i >= 0.0 && i <= 1.0)
			w = i;

		src1 = Imgcodecs.imread("1.jpg");
		src2 = Imgcodecs.imread("2.jpg");
		
		//System.out.println(src1.size()+" "+src2.size());
		
		if (src1.empty()) {
			System.out.println("Error loading src1");
			return;
		} else if (src2.empty()) {
			System.out.println("Error loading src2");
			return;
		}

		Core.addWeighted(src1, w, src2, 1 - w, 0.0, dest);
		HighGui.imshow("Weighted Sum of Images", dest);
		Imgcodecs.imwrite("AddedImages.jpg", dest);
		if (HighGui.waitKey(0) == 27)
			HighGui.destroyAllWindows();
		return;
	}

	public static void main(String[] args) {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		new AddingImages();
		System.exit(0);
	}
}
