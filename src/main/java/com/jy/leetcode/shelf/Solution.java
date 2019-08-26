package com.jy.leetcode.shelf;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jiangyang on 2019/8/26.
 */
public class Solution {

    private static int SHELF_WIDTH;

    public int minHeightShelves(int[][] books, int shelf_width) {
        Solution.SHELF_WIDTH = shelf_width;

        Shelf shelf = new Shelf();
        addLayer(shelf, books[0][0], books[0][1]);

        for (int i = 0; i < books.length; ++i) {
            Book book = new Book(books[i][0], books[i][1]);
            Layer layer = shelf.getBestLayer(book);
            if (layer != null) {
                layer.add(book);
                continue;
            }
        }
    }

    private static void addLayer(List<Layer> shelf, int h, int w) {
        Layer layer = new Layer();
        layer.add(new Book(h, w));
        shelf.add(layer);
    }

    public static class Book {
        int h;
        int w;

        public Book(int h, int w) {
            this.h = h;
            this.w = w;
        }
    }

    private static class Shelf extends ArrayList<Layer> {
        public Layer getBestLayer(Book book) {
            for (Layer layer : this) {
                if (layer.getW() + book.w <= SHELF_WIDTH) {
                    if (layer.getH() >= book.h) {
                        return layer;
                    }
                }
            }
            return null;
        }
    }


    private static class Layer extends ArrayList<Book> {
        public int getW() {
            int res = 0;
            for (Book i : this) {
                res += i.w;
            }
            return res;
        }

        public int getH() {
            int res = 0;
            for (Book i : this) {
                if (i.h > res) {
                    res = i.h;
                }
            }
            return res;
        }

        public boolean allowAdd(Book book) {
            if (getW() + book.w <= SHELF_WIDTH) {
                return true;
            }
            return false;
        }
    }
}
