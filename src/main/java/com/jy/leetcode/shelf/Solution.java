package com.jy.leetcode.shelf;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by jiangyang on 2019/8/26.
 */
public class Solution {

    private static int SHELF_WIDTH;

    public static void main(String[] args) {
//        1求出总宽度除以shelf_width得到n至少需要n层
//        2书按高度倒序，依次放入各层书架，超过某一层宽度则放到上层书架上，直到n层书架无法填放为止，保证上层书架的高度一定小于下层
//        3无法填放书，则看n层书架剩余总宽度是否够放当前的书，如果不够则另起一层放当前的书
//        4如果够放当前的书，移动当前n层书架内的书，原则：书只能从上层往下层填，优先把下层书架填满，空出上层书架，如果发现足够放当前书则停止
//        5如果即使移动也无法空出空间则另起一层
    }

    public int minHeightShelves(int[][] books, int shelf_width) {
        Solution.SHELF_WIDTH = shelf_width;
        Arrays.sort(books, (o1, o2) -> o1[1] > o2[1] ? -1 : 1);
//        int minLayer = (int) Math.ceil(getTotalW(books) / SHELF_WIDTH);

        Shelf shelf = new Shelf();
        addLayer(shelf, books[0][0], books[0][1]);

        for (int i = 0; i < books.length; ++i) {
            Layer lastLayer = shelf.get(shelf.size() - 1);
            if (lastLayer.getW() + books[i][0] <= SHELF_WIDTH) {
                lastLayer.add(new Book(books[i][0], books[i][1]));
            } else if(shelf.getEmptySize()<books[i][0]){
                addLayer(shelf, books[i][0], books[i][1]);
            }else {

            }
        }
        return 0;
    }


    private double getTotalW(int[][] books) {
        int res = 0;
        for (int i = 0; i < books.length; ++i) {
            res += books[i][0];
        }
        return res;
    }

    private static void addLayer(List<Layer> shelf, int w, int h) {
        Layer layer = new Layer();
        layer.add(new Book(w, h));
        shelf.add(layer);
    }

    public static class Book {
        int h;
        int w;

        public Book(int w, int h) {
            this.w = w;
            this.h = h;
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

        public int getEmptySize() {
            int res = 0;
            for (Layer layer : this) {
                res += SHELF_WIDTH - layer.getW();
            }
            return res;
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
