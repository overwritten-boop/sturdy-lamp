# sturdy-lamp
A java library of the basic image processing functions


<h1>Function documentation</h1>


<h2>Basic functions</h2>


<h3>read</h3>

<h4>Arguments</h4>
The read function takes in a filepath of the image to be read.

<h4>Description</h4>
The read function converts a file(@ given filepath) to a BufferedImage object

<h4>Output</h4>
The read function returns a BufferedImage object of the image at the given path


<h3>write</h3>

<h4>Arguments</h4>
The write function takes a filepath(String) and an image(BufferedImage) object.

<h4>Description</h4>
The write function will write the bufferedImage object and will write directly to the file at the filepath.

<h4>Output</h4>
The write function is void, it does not return any value. However the inputted BufferedImage is written directly to the filepath provided.


<h3>rgbin</h3>

<h4>Arguments</h4>
The rgbin function takes 3 integers(r, g, and b values respectively).

<h4>Description</h4>
The rgbin function converts the three integer provided into a single integer used to convey rgb values more easily.

<h4>Output</h4>
The rgbin function will return an integer.


<h2>Alteration functions</h2>


<h3>grayscale</h3>

<h4>Arguments</h4>
The Grayscale function takes in either a filepath of an image(String) or a BufferedImage object.

<h4>Manipulations</h4>
The Grayscale function will take the average value of the r, g, and b values of a pixel. This average becomes the rgb values which gives the image a grayscale feel.

<h4>Output</h4>
The Grayscale function will either return a BufferedImage object(if a BufferedImage was an argument) or it will write directly to the file(if filepath was given).


<h3>inverter</h3>

<h4>Arguments</h4>
The inverter function will take a BufferedImage object or a filepath(String) to a valid image.

<h4>Manipulations</h4>
The inverter function will replace the rgb values with 255 minus the respective value.

<h4>Output</h4>
The inverter function, similar to the grayscale function, returns either a BufferedImage object or it will write directly to the file.


<h3>mirror</h3>

<h4>Arguments</h4>
The mirror function also takes either a filepath(String) or a BufferedImage object.

<h4>Manipulations</h4>
The mirror function flips pixels to the opposite position on the image, giving the image a mirroring effect.

<h4>Output</h4>
The mirror function returns values the same way the grayscale and inverter functions do, either a BufferedImage object or written directly to the filepath provided.


<h3>isocolor</h3>

<h4>Arguments</h4>
The isocolor function takes r,g and b values(Integer) and either a filepath(String) or a BufferedImage object(BufferedImage).

<h4>Manipulations</h4>
The Isocolor function will blank every color that isn't the color provided in the input.

<h4>Output</h4>
The isocolor function either writes directly to the filepath provided or it returns a BufferedImage object


<h1>General documentation</h1>
This library is split into two sections, automatic read-write, and regular. The automatic read-write(marked arw) takes a filepath(String) as an input and automatically writes the finished image to the filepath. The regular(not denoted) functions take a BufferedImage object in and return the finished image as a BufferedImage object.
