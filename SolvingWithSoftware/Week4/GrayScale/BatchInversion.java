package GrayScaleConversion;

import edu.duke.DirectoryResource;
import edu.duke.ImageResource;
import edu.duke.Pixel;

import java.io.File;

public class BatchInversion {
    public ImageResource makeInversion(ImageResource input)
    {
        ImageResource output =new ImageResource(input.getWidth(),input.getWidth());
        for(Pixel outPixel : output.pixels())
        {
            Pixel inPixel=input.getPixel(outPixel.getX(),outPixel.getY());
            outPixel.setRed(255-inPixel.getRed());
            outPixel.setGreen(255-inPixel.getGreen());
            outPixel.setBlue(255-inPixel.getGreen());
        }
        return output;
    }

    public void selectAndConvert()
    {
        DirectoryResource dir=new DirectoryResource();
        for(File file:dir.selectedFiles())
        {
            ImageResource originalImage=new ImageResource(file);
            ImageResource inversionImage=makeInversion(originalImage);
            inversionImage.setFileName("inversion-"+originalImage.getFileName());
            inversionImage.draw();
            inversionImage.save();
        }
    }
    public static void main(String[] args)
    {
       new BatchInversion().selectAndConvert();
    }
}
