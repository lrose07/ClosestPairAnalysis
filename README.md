# Closest Pair Analysis

### Project for Radford University ITEC 360

This program computes the closest pair of points from a list of x, y coordinate points, using both the brute force and divide and conquer algorithms.

To compile: `javac *.java`

To run: `java Driver <flag> < <filename>`
  
Where flag can be:
  * `brute`: runs the brute force algorithm
  * `divide`: runs the divide and conquer algorithm
  * `both`: runs both

And filename is a file containing a list of points, where the first line of the file is the number of points that follow, one pair of coordinates per line.


#### Dev Mode:
To enter dev mode, run `java Driver -dev`

The program will ask how many points (created randomly) and how many runs to perform. It will run both brute and divide.
