package GrayScaleConversion;

import edu.duke.DirectoryResource;
import edu.duke.ImageResource;
import edu.duke.Pixel;

import java.io.File;

public class Image {

    public void multipleImageConversion()
    {
        int x,y;
        DirectoryResource dir=new DirectoryResource();
       for( File file : dir.selectedFiles())
       {
           ImageResource input=new ImageResource(file);
           x=input.getWidth();
           y=input.getHeight();
           ImageResource image2=new ImageResource(x,y);
           for(Pixel pixel:image2.pixels())
           {
               Pixel imagePixel=input.getPixel(pixel.getX(),pixel.getY());
               int grayscalePixel=(imagePixel.getBlue()+imagePixel.getGreen()+imagePixel.getRed())/3;
               pixel.setBlue(grayscalePixel);
               pixel.setGreen(grayscalePixel);
               pixel.setRed(grayscalePixel);
           }
           setNameAndSave(input,image2);
       }
    }

    public void setNameAndSave(ImageResource oldImage,ImageResource newImage)
    {
        String oldName=oldImage.getFileName();
        String newName="gray-"+oldName;
        newImage.setFileName(newName);
        newImage.save();
        newImage.draw();
    }
    public static void main(String[] args)
    {
        new Image().multipleImageConversion();

    }
}
