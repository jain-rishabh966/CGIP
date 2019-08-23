import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.highgui.HighGui;
import org.opencv.imgcodecs.Imgcodecs;

public class Flip {
	public static void main(String[] args) {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		
		//loading the original image
		Mat src = Imgcodecs.imread("1.jpg");
		
		//Making Copies of the original image
		Mat horizontal = src.clone();
		Mat vertical = src.clone();
		Mat both = src.clone();
		
		//Flipping the image using flip function in Core class
		Core.flip(src, horizontal, 1);
		Core.flip(src, vertical, 0);
		Core.flip(src, both, -1);
		
		//showing the images
		HighGui.imshow("Original", src);
		HighGui.imshow("Horizontal", horizontal);
		HighGui.imshow("Vertical", vertical);
		HighGui.imshow("Both", both);
		
		//storing the images
		Imgcodecs.imwrite("HorizontalFlip.jpg", horizontal);
		Imgcodecs.imwrite("VerticalFlip.jpg", vertical);
		Imgcodecs.imwrite("BothFlip.jpg", both);
		
		//waiting for the program for input to exit
		HighGui.waitKey(0);
		System.exit(0);
	}
}
