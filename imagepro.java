import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

class imagepro {
	static BufferedImage read(String path){
		//initializing the return image and file to read
		BufferedImage img = null;
		File f = null;
		
		try{
			//sets the file object to the path given
			f = new File(path);
			
			//reads the file at the path given
			img = ImageIO.read(f);
			
		}catch(Exception e){
			System.out.println(e);
		}
				
		return img;
	}
	static void write(BufferedImage img, String path){
		//the file object that is used for setting the image
		File f = null;
		
		try{
			//sets the file object as the path given
			f = new File(path);
			
			//sets the file at the path to the image given
			ImageIO.write(img, path.substring(path.indexOf('.')+1), f);
		
		//error handling
		}catch(Exception e){
			System.out.println(e);
		}
	}
	static int rgbin(int r, int g, int b){
		int p = 0;
		p = p & r;
		p = p<<8 & g;
		p = p<<8 & b;
		return p;
	}

//autoreadwrite
	//grayscale
	static void arwgrayscale(String path){
		//reads the image
		BufferedImage img = read(path);
		
		//creates a greyscale image of an image
		//gets the height and width of the image
		int height = img.getHeight();
		int width = img.getWidth();
		
		for(int x = 0; x < width; x++){
			for(int y = 0; y < height; y++){
				
				//gets the rgb value at (X, Y)
				int p = img.getRGB(x, y);
				
				//bitshifts p to get the value of the perameter then uses a bitwise & to get the first 8 digits
	            int r = (p >> 16) & 0xff;
	            int g = (p >> 8) & 0xff;
	            int b = p & 0xff;
	            
	            //gets the average rgb values
	            int avg = (r + g + b) / 3;
	            
	            p =(avg << 16) | (avg << 8) | avg;
	            
	            img.setRGB(x, y, p);
	            
			}
		}
		write(img, path);
	}
	
	//color inverter
	static void arwinverter(String path){
		//reads the image
		BufferedImage img = read(path);
		
		//gets inverted colors for a colored image
		int height = img.getHeight();
		int width = img.getWidth();
		
		for(int x = 0; x < width; x++){
			for(int y = 0; y < height; y++){
				int p = img.getRGB(x, y);
				
				//extracts the r, g, and b values
				int r = (p >> 16) & 0xff;
				int g = (p >> 8) & 0xff;
				int b = p & 0xff;
				
				//inverts the colors
				r = 255-r;
				g = 255-g;
				b = 255-b;
				
				//puts the numbers back into the pixel
				p =(r << 16) | (g << 8) | b;
				
				//puts the pixel back into the image
				img.setRGB(x, y, p);
			}
		}
		write(img, path);
	}

	//Mirror
	static void arwmirror(String path){
		//reads the file at the given path
		BufferedImage img = read(path);
		
		//sets the height and width of the img
		int height = img.getHeight();
		int width = img.getWidth();
		
		//gets the rgb values from the image
		BufferedImage newimg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		
		//flips the image
		for(int lx = 0, rx = width - 1; lx < width; lx++, rx--){
			for(int y = 0; y < height; y++){
				int p = img.getRGB(lx, y);	
				newimg.setRGB(rx, y, p);
			}
		}
		write(img, path);
	}

	//isocolor
	static void arwiso(String path, int rgb){
		//takes the path of the image, and the r, g, and b values that should be isolated(as a binary number)
		//reads the image
		BufferedImage img = read(path);
		
		//gets the iso rgb
		int r = (rgb >> 16) & 0xff;
		int g = (rgb >> 8) & 0xff;
		int b = rgb & 0xff;
		
		//sets the height and width of the img
		int height = img.getHeight();
		int width = img.getWidth();
		
		//gets the rgb values from the image
		BufferedImage newimg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		
		//loops for each pixel
		for(int x = 0; x < width; x++){
			for(int y = 0; y < height; y++){
				//gets the pixel rgb values
				int p = img.getRGB(x, y);
				
				//gets the individual values
				int imgr = (p >> 16) & 0xff;
				int imgg = (p >> 8) & 0xff;
				int imgb = p & 0xff;
				
				if(!(r == imgr && g == imgg && b == imgb)){
					imgr = 000;
					imgg = 000;
					imgb = 000;
					p = (imgr << 16) | (imgg << 8) | imgb;
				}
				img.setRGB(x, y, p);
			}
		}
		
		write(img, path);
	}
	
//BufferedImage
	//grayscale
	public static BufferedImage grayscale(BufferedImage img){
		//creates a greyscale image of an image
		//gets the height and width of the image
		int height = img.getHeight();
		int width = img.getWidth();
		
		for(int x = 0; x < width; x++){
			for(int y = 0; y < height; y++){
				
				//gets the rgb value at (X, Y)
				int p = img.getRGB(x, y);
				
				//bitshifts p to get the value of the perameter then uses a bitwise & to get the first 8 digits
	            int r = (p >> 16) & 0xff;
	            int g = (p >> 8) & 0xff;
	            int b = p & 0xff;
	            
	            //gets the average rgb values
	            int avg = (r + g + b) / 3;
	            
	            p =(avg << 16) | (avg << 8) | avg;
	            
	            img.setRGB(x, y, p);
	            
			}
		}
		
		return img;
	}
	
	//color inverter
	public static BufferedImage inverter(BufferedImage img){
		//gets inverted colors for a colored image
		int height = img.getHeight();
		int width = img.getWidth();
		
		for(int x = 0; x < width; x++){
			for(int y = 0; y < height; y++){
				int p = img.getRGB(x, y);
				
				//extracts the r, g, and b values
				int r = (p >> 16) & 0xff;
				int g = (p >> 8) & 0xff;
				int b = p & 0xff;
				
				//inverts the colors
				r = 255-r;
				g = 255-g;
				b = 255-b;
				
				//puts the numbers back into the pixel
				p = (r << 16) | (g << 8) | b;
				
				//puts the pixel back into the image
				img.setRGB(x, y, p);
			}
		}
		return img;
	}
	
	//mirror
	public static BufferedImage mirror(BufferedImage img){
		//sets the height and width of the image
		int height = img.getHeight();
		int width = img.getWidth();
		
		//gets the rgb values of the image
		BufferedImage newimg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		
		//flips the image
		for(int lx = 0, rx = width - 1; lx < width; lx++, rx--){
			for(int y = 0; y < height; y++){
				int p = img.getRGB(lx, y);	
				newimg.setRGB(rx, y, p);
			}
		}
		return newimg;
	}
	
	//isolates a color
	public static BufferedImage isocolor(BufferedImage img, int rgb){

		//gets the iso rgb
		int r = (rgb >> 16) & 0xff;
		int g = (rgb >> 8) & 0xff;
		int b = rgb & 0xff;
		
		//sets the height and width of the img
		int height = img.getHeight();
		int width = img.getWidth();
		
		//gets the rgb values from the image
		BufferedImage newimg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		
		//loops for each pixel
		for(int x = 0; x < width; x++){
			for(int y = 0; y < height; y++){
				//gets the pixel rgb values
				int p = img.getRGB(x, y);
				
				//gets the individual values
				int imgr = (p >> 16) & 0xff;
				int imgg = (p >> 8) & 0xff;
				int imgb = p & 0xff;
				
				if(!(r == imgr && g == imgg && b == imgb)){
					imgr = 000;
					imgg = 000;
					imgb = 000;
					p = (imgr << 16) | (imgg << 8) | imgb;
				}
				img.setRGB(x, y, p);
			}
		}
		return img;
	}
}
