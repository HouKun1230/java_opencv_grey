package java_opencv;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import java.awt.image.DataBufferByte;

import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;




public class javacv {

	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		System.loadLibrary( Core.NATIVE_LIBRARY_NAME );
//	      Mat mat = Mat.eye( 3, 3, CvType.CV_8UC1 );
//	      System.out.println( "mat = " + mat.dump() );
//	   }
	
	 try {
         System.loadLibrary( Core.NATIVE_LIBRARY_NAME );
         File input = new File("About Thunder Bay.jpg");
         BufferedImage image = ImageIO.read(input);	

         byte[] data = ((DataBufferByte)image.getRaster().getDataBuffer()).getData();
        // int[] data = ((DataBufferInt)image.getRaster().getDataBuffer()).getData();
         Mat mat = new Mat(image.getHeight(), image.getWidth(), CvType.CV_8UC3);
         mat.put(0, 0, data);

         Mat mat1 = new Mat(image.getHeight(),image.getWidth(),CvType.CV_8UC1);
         Imgproc.cvtColor(mat, mat1, Imgproc.COLOR_RGB2GRAY);

         byte[] data1 = new byte[mat1.rows() * mat1.cols() * (int)(mat1.elemSize())];
         mat1.get(0, 0, data1);
         BufferedImage image1 = new BufferedImage(mat1.cols(),mat1.rows(), BufferedImage.TYPE_BYTE_GRAY);
         image1.getRaster().setDataElements(0, 0, mat1.cols(), mat1.rows(), data1);

         File ouptut = new File("result.jpg");
         ImageIO.write(image1, "jpg", ouptut);
         
      } catch (Exception e) {
         System.out.println("Error: " + e.getMessage());
      }

	}
}
	


