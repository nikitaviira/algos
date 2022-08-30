package com.company;

// An image is represented by an m x n integer grid image where image[i][j] represents the pixel value of the image.
//You are also given three integers sr, sc, and color. You should perform a flood fill on the image starting from the pixel image[sr][sc].
//To perform a flood fill, consider the starting pixel, plus any pixels connected 4-directionally to the starting
// pixel of the same color as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same color),
// and so on. Replace the color of all of the aforementioned pixels with color.
//Return the modified image after performing the flood fill.
//
//Input: image = [[1,1,1],[1,1,0],[1,0,1]], sr = 1, sc = 1, color = 2
//Output: [[2,2,2],[2,2,0],[2,0,1]]
//Explanation: From the center of the image with position (sr, sc) = (1, 1) (i.e., the red pixel),
// all pixels connected by a path of the same color as the starting pixel (i.e., the blue pixels) are colored with the new color.
//Note the bottom corner is not colored 2, because it is not 4-directionally connected to the starting pixel.

import java.util.Arrays;
import java.util.stream.Collectors;

//https://leetcode.com/problems/flood-fill/
public class FloodFill {
  public static void main(String[] args) {
    int[][] fill = floodFill(new int[][] {
        {1, 0, 0, 0, 0},
        {0, 0, 0, 1, 1},
        {1, 1, 2, 1, 0},
        {1, 1, 3, 1, 1},
        {3, 1, 1, 1, 0}},
      2, 0, 2);

    for (int[] ints : fill) {
      System.out.println(Arrays.stream(ints).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
    }
  }

  public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
    int initColor = image[sr][sc];
    if (initColor == color) return image;
    return fill(image, sr, sc, initColor, color);
  }

  public static int[][] fill(int[][] image, int y, int x, int initColor, int color) {
    image[y][x] = color;
    if (y - 1 >= 0 && image[y - 1][x] == initColor) fill(image, y - 1, x, initColor, color);
    if (y + 1 <= image.length - 1 && image[y + 1][x] == initColor) fill(image, y + 1, x, initColor, color);
    if (x - 1 >= 0 && image[y][x - 1] == initColor) fill(image, y, x - 1, initColor, color);
    if (x + 1 <= image[0].length - 1 && image[y][x + 1] == initColor) fill(image, y, x + 1, initColor, color);
    return image;
  }
}
