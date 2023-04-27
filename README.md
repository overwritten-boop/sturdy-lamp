# sturdy-lamp
A java library of the basic image processing functions
<h1>Function documentation</h1>
<h2>grayscale</h2>
<h4>Arguments</h4>
The Grayscale function takes in either a filepath of an image(String) or a BufferedImage object.
<h4>Manipulations</h4>
The Grayscale function will take the average value of the r, g, and b values of a pixel. This average becomes the rgb values which gives the image a grayscale feel.
<h4>Output</h4>
The Grayscale function will either return a BufferedImage object(if a BufferedImage was an argument) or it will write directly to the file(if filepath was given).
<h2>inverter</h2>
<h4>Arguments</h4>
The inverter function will take a BufferedImage object or a filepath(String) to a valid image.
<h4>Manipulations</h4>
The inverter function will replace the rgb values with 255 minus the respective value.
<h4>Output</h4>
The inverter function, similar to the grayscale function, returns either a BufferedImage object or it will write directly to the file.
<h2>mirror</h2>
<h4>Arguments</h4>
The mirror function also takes either a filepath(String) or a BufferedImage object.
<h4>Manipulations</h4>
The mirror function flips pixels to the opposite position on the image, giving the image a mirroring effect.
<h4>Output</h4>
The mirror function returns values the same way the grayscale and inverter functions do, either a BufferedImage object or written directly to the filepath provided.
<h1>General documentation</h1>
