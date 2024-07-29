package org.example.w22.common;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class PageInfo {

    private int page; //current page
    private int size; //size of page
    private int start; //page of start
    private int end; //page of end
    private boolean prev;
    private boolean next;

    public PageInfo(int page, int size, int total) {
        this.page = page <= 0? 1: page;
        end = (int)(Math.ceil(this.page / 10.0) * 10);
        start = end - 9;
        prev = start == 1 ? false:true;
        if(end * size < total){
            next = true;
        }else{
            next = false;
            end = (int)(Math.ceil(total/(double)size));
        }
    }

}
