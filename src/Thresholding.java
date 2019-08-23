import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;

public class Thresholding {
	public static void main(String[] args) {
		System.load(Core.NATIVE_LIBRARY_NAME);
		Mat src = Imgcodecs.imread("1.jpg");
		Mat gaus = src.clone();
		
	}
}
