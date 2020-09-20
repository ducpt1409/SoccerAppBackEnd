package com.ptd.dao;

import com.ptd.entity.TeamInvitation;

import java.util.List;

public interface TeamInvitationDAO {
    public void addNewTeamInvitation(TeamInvitation teamInvitation);

    //Lời team mời đang đợi.
    public List<TeamInvitation> getTeamInvitationByTeamWaiting(int userId);

    //Tất cả lời xin vào team của user
    public List<TeamInvitation> getTeamInvitationByUser(int userId);

    //Tất cả lời xin vào team
    public List<TeamInvitation> getTeamInvitationByUserWaiting(int teamId);

    //Tất cả lời mời của team đã gửi
    public List<TeamInvitation> getTeamInvitationByTeamInvited(int teamId);

    //Chấp nhận lời mời
    public void approveInvitation(int invitationId);

    //Từ chối lời mời
    public void refuseInvitation(int invitationId);

    //Xoá lời mời
    public void deleteInvitation(int invitationId);
}
