package com.amg.web.common.util;

import java.util.Map;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import lombok.Data;

/**
 * PageProxy
 */

 @Component @Data @Lazy
public class PageProxy {
    private int pageNum, pageSize, blockSize, startRow,
                endRow, startPage, endPage, prevBlock, nextBlock, totalCount;
    private String search;
    
    // 다음 > 과 이전이 보일지 말지 정함
    private boolean existPrev, existNext;

    public void execute(Map<?, ?> paramMap){
        // 내부에서 쓰는 변수는 _로 함 (임시로 지정할때나)
        String _pageNum = (String)paramMap.get("page_num");

        //customer페이지에서 product페이지 넘어갈때 1페이지로 지정.
        pageNum = (_pageNum == null) ? 1 : Integer.parseInt(_pageNum);
        
        //한 화면에 보이는 글의 수
        String _pageSize = (String)paramMap.get("page_size");
        pageSize = (_pageSize == null) ? 5 : Integer.parseInt(_pageSize); 

        //blocksize (1~10까지면 10) 기본값 5 <- -> ?
        String _blockSize = (String)paramMap.get("block_size");
        blockSize = (_blockSize == null) ? 1 : Integer.parseInt(_blockSize);

        //totalCount = DB에 있는 테이블에서 개수 가져옴. 
        int nmg = totalCount % pageSize;

        // 맨 마지막 페이지 2개여도 페이지 1개 늘어나야하니까.
        int pageCount = (nmg == 0) ? totalCount / pageSize : totalCount / pageSize + 1;

        // startRow (2페이지면 1)
        // int startRow = 
        
        // endRow (2페이지면 5)


    }
    
}