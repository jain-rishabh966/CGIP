import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.highgui.HighGui;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class TestOpenCV {
	public static void main(String args[]) {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		Mat src1, edges = new Mat();
		Mat log = new Mat();
		Mat dest = new Mat();
		Mat threshold = new Mat();
		Mat median = new Mat();
		Mat dog = new Mat();
		Mat src2 = new Mat();
		Mat histeq = new Mat();
		Mat bw = new Mat();
		Mat sobx = new Mat();
		Mat soby = new Mat();
		Mat sob = new Mat();
		Mat prex = new Mat();
		Mat prey = new Mat();
		Mat pre = new Mat();

		Mat kernelx = new Mat(3, 3, CvType.CV_8UC1);
		kernelx.put(0, 0, 1);
		kernelx.put(0, 1, 1);
		kernelx.put(0, 2, 1);
		kernelx.put(1, 0, 0);
		kernelx.put(1, 1, 0);
		kernelx.put(1, 2, 0);
		kernelx.put(2, 0, -1);
		kernelx.put(2, 1, -1);
		kernelx.put(2, 2, -1);

		Mat kernely = new Mat(3, 3, CvType.CV_8UC1);
		kernely.put(0, 0, -1);
		kernely.put(0, 1, 0);
		kernely.put(0, 2, 1);
		kernely.put(1, 0, -1);
		kernely.put(1, 1, 0);
		kernely.put(1, 2, 1);
		kernely.put(2, 0, -1);
		kernely.put(2, 1, 0);
		kernely.put(2, 2, 1);

		//loading the original image
		src1 = Imgcodecs.imread("1.jpg");
		
		//applying Gaussian Blur to an image
		Imgproc.GaussianBlur(src1, dest, new Size(25, 25), 0);
		HighGui.imshow("Gaussian Blur", dest);
		Imgcodecs.imwrite("Gaussian.jpg", dest);
		
		//subtracting images
		Core.subtract(src1, dest, dog);
		HighGui.imshow("DoG", dog);
		Imgcodecs.imwrite("DoG.jpg", dog);
		
		//making a dummy image for Laplacian filter
		Imgproc.GaussianBlur(src1, src2, new Size(3, 3), 0);
		Imgproc.Laplacian(src2, log, CvType.CV_8U);
		HighGui.imshow("LoG", log);
		Imgcodecs.imwrite("LoG.jpg", log);
		
		//thresholding the image
		Imgproc.threshold(log, threshold, 10, 255, Imgproc.THRESH_BINARY);
		HighGui.imshow("Threshold of LoG", threshold);
		Imgcodecs.imwrite("Threshold.jpg", threshold);

		//applying median blur on the thresholded image
		Imgproc.medianBlur(threshold, median, 3);
		HighGui.imshow("Median of Thereshold", median);
		Imgcodecs.imwrite("Median.jpg", median);
		
		//applying Canny edge detection
		Imgproc.Canny(src1, edges, 150, 300);
		HighGui.imshow("Canny", edges);
		Imgcodecs.imwrite("Canny.jpg", edges);

		//making image black and white
		Imgproc.cvtColor(src1, bw, Imgproc.COLOR_BGR2GRAY);
		HighGui.imshow("B/W", bw);
		Imgcodecs.imwrite("B/W.jpg", bw);

		//equalizing histogram of the black and white image
		Imgproc.equalizeHist(bw, histeq);
		HighGui.imshow("HistEq", histeq);
		Imgcodecs.imwrite("HistEq.jpg", dog);

		//applying Sobel filter in x and y directions
		Imgproc.Sobel(src1, sobx, CvType.CV_8U, 1, 0);
		Imgproc.Sobel(src1, soby, CvType.CV_8U, 0, 1);
		HighGui.imshow("Sob-X", sobx);
		HighGui.imshow("Sob-Y", soby);
		Core.add(sobx, soby, sob);
		HighGui.imshow("Sobel", sob);
		Imgcodecs.imwrite("Sobel.jpg", sob);

		//applying Prewitt filter in x and y direction
		Imgproc.filter2D(src1, prex, -1, kernelx);
		Imgproc.filter2D(src1, prey, -1, kernely);
		Core.subtract(prex, prey, pre);
		HighGui.imshow("Prewitt", pre);
		Imgcodecs.imwrite("Prewitt.jpg", pre);

		HighGui.waitKey(0);
		System.exit(0);
	}
}