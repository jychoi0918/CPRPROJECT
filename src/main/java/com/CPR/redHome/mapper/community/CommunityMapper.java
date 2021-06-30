package com.CPR.redHome.mapper.community;

import com.CPR.redHome.dto.community.CommentsDto;
import com.CPR.redHome.dto.community.CommunityDto;
import com.CPR.redHome.paging.Criteria;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface CommunityMapper {

    //총 커뮤니티 글 수 가져오기
   int selectCommunityTotalCnt(@RequestParam String reply, @RequestParam String searchType, @RequestParam String searchKeyword);

   //전체 커뮤니티 글 가져오기
   List<CommunityDto> selectAllCommunities(@RequestParam String reply, @RequestParam String orderType, @RequestParam int recordsPerPage, @RequestParam int firstRecordIndex,
                                          @RequestParam String searchType, @RequestParam String searchKeyword);

   //특정 커뮤니티 글에 대한 총 코멘트 수 가져오기
    int selectCommentsCnt(Long communityId);

    //특정 커뮤니티 글 가져오기
    CommunityDto selectCommunity(Long communityId);

    //특정 커뮤니티 글에 대한 전체 코멘트 가져오기
    List<CommentsDto> selectAllComments(@RequestParam Long communityId, @RequestParam int recordsPerPage, @RequestParam int firstRecordIndex);

    //커뮤니티 글 조회수 증가
    void updateCommunityHitCnt(Long communityId);

    //특정 커뮤니티 삭제
    void deleteCommunity(Long communityId);
    
    //코멘트 등록
    void insertComment(@RequestParam("comment") CommentsDto commentsDto);

    //커뮤니티 글 답변상태 완료로 변경
    void updateCommunityStateComplete(Long communityId);

    //커뮤니티 글 답변상태 대기로 변경
    void updateCommunityStateWait(Long communityId);



}
