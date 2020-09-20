package com.ptd.controller;

import com.ptd.model.*;
import com.ptd.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class MainController {

    @Autowired
    UserService userService;

    @Autowired
    AccountService accountService;

    @Autowired
    ProvinceService provinceService;

    @Autowired
    DistrictService districtService;

    @Autowired
    WardService wardService;

    @Autowired
    TeamService teamSerivce;

    @Autowired
    TeamPlayerService teamPlayerService;

    @Autowired
    TeamInvitationService teamInvitationService;

    @Autowired
    MatchService matchService;

    @Autowired
    MatchInvitationService matchInvitationService;

    @Autowired
    ScoreBoardService scoreBoardService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public @ResponseBody
    List<UserDTO> login(HttpServletRequest request, @RequestBody Map<String, String> json) {
        String username = json.get("username");
        String password = json.get("password");
        List<UserDTO> userDTOs = userService.getUserByLogin(username, password);
        return userDTOs;
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public @ResponseBody
    String signUp(HttpServletRequest request, @RequestBody Map<String, String> json) {
        String username = json.get("username");
        String password = json.get("password");
        String name = json.get("name");

        int account = accountService.getCountAccount(username);
        if (account != 0) {
            return "{\"msg\":\"exist\"}";
        } else {
            try {
                userService.addUser(username, password, name);
                List<UserDTO> userDTOs = userService.getUserByLogin(username, password);
                return "{\"msg\":\"success\", \"userId\":\"" + userDTOs.get(0).getId() + "\" }";
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return "{\"msg\":\"success\"}";
    }

    @RequestMapping(value = "/getUser", method = RequestMethod.POST)
    public @ResponseBody
    UserDTO getUser(HttpServletRequest request, @RequestBody Map<String, String> json) {
        int id = Integer.parseInt(json.get("id"));
        UserDTO userDTO = new UserDTO();
        try {
            userDTO = userService.getUserById(id);
            return userDTO;
        } catch (Exception e) {
            return null;
        }

    }

    @RequestMapping(value = "updateUser", method = RequestMethod.POST)
    public @ResponseBody
    String updateUser(HttpServletRequest request, @RequestBody Map<String, String> json) {

        UserDTO userDTO = new UserDTO();
        userDTO.setId(Integer.parseInt(json.get("id")));
        userDTO.setName(json.get("name"));
        userDTO.setDoB(json.get("doB"));
        userDTO.setLocation(json.get("location"));
        userDTO.setEmail(json.get("email"));
        userDTO.setPhone(json.get("phone"));
        userDTO.setIntroduce(json.get("introduce"));
        userDTO.setAvatarUrl(json.get("avatarUrl"));

        try {
            userService.updateUser(userDTO);
        } catch (Exception e) {
            return "{\"msg\":\"error\"}";
        }

        return "{\"msg\":\"success\"}";
    }

    @RequestMapping(value = "updatePassword", method = RequestMethod.POST)
    public @ResponseBody
    String updatePassword(HttpServletRequest request, @RequestBody Map<String, String> json) {
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setId(Integer.parseInt(json.get("id")));
        accountDTO.setUsername(json.get("username"));
        accountDTO.setPassword(json.get("password"));

        try {
            accountService.updatePassword(accountDTO);
        } catch (Exception e) {
            return "{\"msg\":\"error\"}";
        }
        return "{\"msg\":\"success\"}";
    }

    @RequestMapping(value = "all-province", method = RequestMethod.POST)
    public @ResponseBody
    List<ProvinceDTO> getAllProvince() {
        try {
            return provinceService.getAllProvince();
        } catch (Exception e) {
            return null;
        }
    }

    @RequestMapping(value = "district-by-province", method = RequestMethod.POST)
    public @ResponseBody
    List<DistrictDTO> getDistrictByProvince(@RequestBody Map<String, String> json) {
        String provinceId = json.get("provinceId");
        try {
            return districtService.getDistrictByProvince(provinceId);
        } catch (Exception e) {
            return null;
        }
    }

    @RequestMapping(value = "ward-by-district", method = RequestMethod.POST)
    public @ResponseBody
    List<WardDTO> getWardByDistrict(@RequestBody Map<String, String> json) {
        String districtId = json.get("districtId");
        try {
            return wardService.getWardByDistrict(districtId);
        } catch (Exception e) {
            return null;
        }
    }

    @RequestMapping(value = "add-new-team", method = RequestMethod.POST)
    public @ResponseBody
    String addNewTeam(@RequestBody Map<String, String> json) {
        String teamName = json.get("teamName");
        String avatarUrl = json.get("url");
        String ward_id = json.get("ward_id");
        String description = json.get("description");
        String position = json.get("position");
        int userId = Integer.parseInt(json.get("userId"));

        WardDTO wardDTO = new WardDTO();
        wardDTO.setId(ward_id);
        TeamLocationDTO teamLocation = new TeamLocationDTO();
        teamLocation.setWardDTO(wardDTO);

        TeamDTO teamDTO = new TeamDTO();
        teamDTO.setName(teamName);
        teamDTO.setAvatarUrl(avatarUrl);
        teamDTO.setDescription(description);
        teamDTO.setTeamLocationDTO(teamLocation);

        try {
            teamSerivce.addTeam(teamDTO, position, userId);
        } catch (Exception e) {
            e.printStackTrace();
            return "{\"msg\":\"error\"}";

        }
        return "{\"msg\":\"success\"}";
    }

    @RequestMapping(value = "get-team-by-id", method = RequestMethod.POST)
    public @ResponseBody
    TeamDTO getTeam(@RequestBody Map<String, String> json) {
        int teamId = Integer.parseInt(json.get("teamId"));
        try {
            return teamSerivce.getTeamById(teamId);
        } catch (Exception e) {
            return null;
        }
    }

    @RequestMapping(value = "get-teams-by-user", method = RequestMethod.POST)
    public @ResponseBody
    List<TeamDTO> getTeams(@RequestBody Map<String, String> json) {
        int userId = Integer.parseInt(json.get("userId"));
        List<TeamDTO> teamDTOS = new ArrayList<>();
        teamDTOS = teamSerivce.getTeamByUser(userId);

        return teamDTOS;
    }

    @RequestMapping(value = "get-teams-by-name", method = RequestMethod.POST)
    public @ResponseBody
    List<TeamDTO> getTeamsByName(@RequestBody Map<String, String> json) {
        String name = json.get("teamName");

        List<TeamDTO> teamDTOS = teamSerivce.getTeamByName(name);

        return teamDTOS;
    }

    @RequestMapping(value = "get-list-teamplayer", method = RequestMethod.POST)
    public @ResponseBody
    List<TeamPlayerDTO> getTeamPlayers(@RequestBody Map<String, String> json) {
        int teamId = Integer.parseInt(json.get("teamId"));

        List<TeamPlayerDTO> teamPlayerDTOS = teamPlayerService.getPlayersByTeam(teamId);

        return teamPlayerDTOS;
    }

    @RequestMapping(value = "update-team-info", method = RequestMethod.POST)
    public @ResponseBody
    String updateTeamInfo(@RequestBody Map<String, String> json) {
        int teamId = Integer.parseInt(json.get("teamId"));
        String teamName = json.get("teamName");
        String avatarUrl = json.get("avatarUrl");
        String description = json.get("description");
        String wardId = json.get("ward_id");

        TeamDTO teamDTO = new TeamDTO();
        teamDTO.setId(teamId);
        teamDTO.setName(teamName);
        teamDTO.setAvatarUrl(avatarUrl);
        teamDTO.setDescription(description);

        try {
            teamSerivce.updateTeam(teamDTO, wardId);
        } catch (Exception e) {
            return "{\"msg\":\"error\"}";
        }

        return "{\"msg\":\"success\"}";
    }

    @RequestMapping(value = "get-user-by-name", method = RequestMethod.POST)
    public @ResponseBody
    List<UserDTO> getUserbyName(@RequestBody Map<String, String> json) {
        String name = json.get("name");
        return userService.getUserByNameLike(name);
    }

    @RequestMapping(value = "make-invitation-user", method = RequestMethod.POST)
    public @ResponseBody
    String makeInvitationUser(@RequestBody Map<String, String> json) {
        int inviteUser_id = Integer.parseInt(json.get("invite_user"));
        int invitedBy_id = Integer.parseInt(json.get("invite_by"));
        int teamId = Integer.parseInt(json.get("teamId"));
        String position = json.get("position");
        String invitation = json.get("invitation");
        String date_time = json.get("date_time");

        TeamInvitationDTO teamInvitationDTO = new TeamInvitationDTO();
        teamInvitationDTO.setPosition(position);
        teamInvitationDTO.setNote(invitation);
        teamInvitationDTO.setDate_time(date_time);

        UserDTO userInvite = new UserDTO();
        userInvite.setId(inviteUser_id);
        UserDTO inviteByUser = new UserDTO();
        inviteByUser.setId(invitedBy_id);
        TeamDTO teamDTO = new TeamDTO();
        teamDTO.setId(teamId);

        teamInvitationDTO.setUser_invite(userInvite);
        teamInvitationDTO.setInvite_by(inviteByUser);
        teamInvitationDTO.setTeamDTO(teamDTO);

        try {
            teamInvitationService.addNewTeamInvitation(teamInvitationDTO);
        } catch (Exception e) {
            return "{\"msg\":\"error\"}";
        }
        return "{\"msg\":\"success\"}";
    }

    @RequestMapping(value = "user-get-waiting-invitation", method = RequestMethod.POST)
    public @ResponseBody
    List<TeamInvitationDTO> userGetWaitingInvitation(@RequestBody Map<String, String> json) {
        int userId = Integer.parseInt(json.get("userId"));
        return teamInvitationService.getTeamInvitationByTeamWaiting(userId);
    }

    @RequestMapping(value = "approve-team-invitation", method = RequestMethod.POST)
    public @ResponseBody
    String approveTeamInvitation(@RequestBody Map<String, String> json) {
        int invitationId = Integer.parseInt(json.get("invitationId"));
        int teamId = Integer.parseInt(json.get("teamId"));
        int userId = Integer.parseInt(json.get("userId"));
        String position = json.get("position");

        try {
            teamInvitationService.approveTeamInvitation(invitationId);
            teamPlayerService.addTeamPlayer(teamId, userId, position);
        } catch (Exception e) {
            return "{\"msg\":\"error\"}";
        }
        return "{\"msg\":\"success\"}";
    }

    @RequestMapping(value = "refuse-team-invitation", method = RequestMethod.POST)
    public @ResponseBody
    String refuseTeamInvitation(@RequestBody Map<String, String> json) {
        int invitationId = Integer.parseInt(json.get("invitationId"));
        try {
            teamInvitationService.refuseTeamInvitation(invitationId);
        } catch (Exception e) {
            return "{\"msg\":\"error\"}";
        }
        return "{\"msg\":\"success\"}";
    }

    @RequestMapping(value = "delete-team-invitation", method = RequestMethod.POST)
    public @ResponseBody
    String deleteTeamInvitation(@RequestBody Map<String, String> json) {
        int invitationId = Integer.parseInt(json.get("invitationId"));

        try {
            teamInvitationService.refuseTeamInvitation(invitationId);
        } catch (Exception e) {
            return "{\"msg\":\"error\"}";
        }
        return "{\"msg\":\"success\"}";
    }

    @RequestMapping(value = "team-get-sent-invitation", method = RequestMethod.POST)
    public @ResponseBody
    List<TeamInvitationDTO> teamGetSentInvitation(@RequestBody Map<String, String> json) {
        int teamId = Integer.parseInt(json.get("teamId"));
        return teamInvitationService.getTeamInvitationByTeamSented(teamId);
    }

    @RequestMapping(value = "user-get-sent-invitation", method = RequestMethod.POST)
    public @ResponseBody
    List<TeamInvitationDTO> userGetSentInvitation(@RequestBody Map<String, String> json) {
        int userId = Integer.parseInt(json.get("userId"));
        return teamInvitationService.getTeamInvitationByUser(userId);
    }

    @RequestMapping(value = "team-get-waiting-invitation", method = RequestMethod.POST)
    public @ResponseBody
    List<TeamInvitationDTO> teamGetWaitingInvitation(@RequestBody Map<String, String> json) {
        int teamId = Integer.parseInt(json.get("teamId"));
        return teamInvitationService.getTeamInvitationByUserWaiting(teamId);
    }

    @RequestMapping(value = "make-new-match", method = RequestMethod.POST)
    public @ResponseBody
    String makeNewMatch(@RequestBody Map<String, String> json) {
        int teamId = Integer.parseInt(json.get("teamId"));
        String mathName = json.get("matchName");
        String location = json.get("location");
        String time = json.get("time");
        String note = json.get("note");

        MatchDTO matchDTO = new MatchDTO();
        matchDTO.setNote(note);
        matchDTO.setTime(time);
        matchDTO.setLocation(location);
        matchDTO.setMatch_name(mathName);

        try {
            matchService.matchMaking(matchDTO, teamId);
        } catch (Exception e) {
            return "{\"msg\":\"error\"}";
        }
        return "{\"msg\":\"success\"}";
    }

    @RequestMapping(value = "get-match-by-id", method = RequestMethod.POST)
    public @ResponseBody
    MatchDTO getMatchById(@RequestBody Map<String, String> json) {
        int matchId = Integer.parseInt(json.get("matchId"));
        try {
            return matchService.getMatchById(matchId);
        } catch (Exception e) {
            return null;
        }
    }

    @RequestMapping(value = "get-created-match", method = RequestMethod.POST)
    public @ResponseBody
    List<MatchDTO> getCreatedMatches(@RequestBody Map<String, String> json) {
        int teamId = Integer.parseInt(json.get("teamId"));
        List<MatchDTO> matchDTOS = matchService.getCreatedMatch(teamId);
        return matchDTOS;
    }

    @RequestMapping(value = "make-match-invitation", method = RequestMethod.POST)
    public @ResponseBody
    String makeMatchInvitation(@RequestBody Map<String, String> json) {
        int teamInvite = Integer.parseInt(json.get("teamInvite"));
        int matchId = Integer.parseInt(json.get("matchId"));
        int type = Integer.parseInt(json.get("type"));
        String time = json.get("time");
        String note = json.get("note");

        MatchInvitationDTO matchInvitationDTO = new MatchInvitationDTO();
        matchInvitationDTO.setNote(note);
        matchInvitationDTO.setTime(time);
        matchInvitationDTO.setType(type);

        TeamDTO teamDTO = new TeamDTO();
        teamDTO.setId(teamInvite);
        MatchDTO matchDTO = new MatchDTO();
        matchDTO.setId(matchId);

        matchInvitationDTO.setTeamInvite(teamDTO);
        matchInvitationDTO.setMatchDTO(matchDTO);
        try {
            matchInvitationService.makeInvitation(matchInvitationDTO);
        } catch (Exception e) {
            return "{\"msg\":\"error\"}";
        }
        return "{\"msg\":\"success\"}";
    }

    @RequestMapping(value = "change-match-status", method = RequestMethod.POST)
    public @ResponseBody
    String changeMatchStatus(@RequestBody Map<String, String> json) {
        int matchId = Integer.parseInt(json.get("matchId"));
        int status = Integer.parseInt(json.get("status"));
        try {
            matchService.updateStatusMatch(matchId, status);
        } catch (Exception e) {
            return "{\"msg\":\"error\"}";
        }
        return "{\"msg\":\"success\"}";

    }

    @RequestMapping(value = "delete-match", method = RequestMethod.POST)
    public @ResponseBody
    String deleteMatch(@RequestBody Map<String, String> json) {
        int matchId = Integer.parseInt(json.get("matchId"));
        try {
            matchService.deleteMatch(matchId);
        } catch (Exception e) {
            return "{\"msg\":\"error\"}";
        }
        return "{\"msg\":\"success\"}";

    }

    @RequestMapping(value = "get-sent-match-invitation", method = RequestMethod.POST)
    public @ResponseBody
    List<MatchInvitationDTO> getSentMatchInvitation(@RequestBody Map<String, String> json) {
        int matchId = Integer.parseInt(json.get("matchId"));
        return matchInvitationService.getSentMatchInvitation(matchId);
    }

    @RequestMapping(value = "get-received-match-invitation", method = RequestMethod.POST)
    public @ResponseBody
    List<MatchInvitationDTO> getReceivedMatchInvitation(@RequestBody Map<String, String> json) {
        int matchId = Integer.parseInt(json.get("matchId"));
        return matchInvitationService.getReceivedMatchInvitation(matchId);
    }

    @RequestMapping(value = "get-waiting-match-invitation", method = RequestMethod.POST)
    public @ResponseBody
    List<MatchInvitationDTO> getWaitingMatchInvitation(@RequestBody Map<String, String> json) {
        int teamId = Integer.parseInt(json.get("teamId"));
        return matchInvitationService.getWaitingMatchInvitation(teamId);
    }

    @RequestMapping(value = "update-match-invitation-status", method = RequestMethod.POST)
    public @ResponseBody
    String updateMatchInvitationStatus(@RequestBody Map<String, String> json) {
        int invitationId = Integer.parseInt(json.get("invitationId"));
        int status = Integer.parseInt(json.get("status"));
        try {
            matchInvitationService.updateStatusInvitation(invitationId, status);

        } catch (Exception e) {
            return "{\"msg\":\"error\"}";
        }
        return "{\"msg\":\"success\"}";

    }

    @RequestMapping(value = "delete-match-invitation", method = RequestMethod.POST)
    public @ResponseBody
    String deleteMatchInvitation(@RequestBody Map<String, String> json) {
        int invitationId = Integer.parseInt(json.get("invitationId"));
        try {
            matchInvitationService.deleteInvitation(invitationId);
        } catch (Exception e) {
            return "{\"msg\":\"error\"}";
        }
        return "{\"msg\":\"success\"}";

    }

    @RequestMapping(value = "approve-match-invitation", method = RequestMethod.POST)
    public @ResponseBody
    String approveMatchInvitation(@RequestBody Map<String, String> json) {
        int invitationId = Integer.parseInt(json.get("invitationId"));
        int matchId = Integer.parseInt(json.get("matchId"));
        int teamInvite = Integer.parseInt(json.get("teamInvite"));
        try {
            matchService.addTeamInviteToMatch(matchId, teamInvite);
            matchInvitationService.updateStatusInvitation(invitationId, 2);
        } catch (Exception e) {
            return "{\"msg\":\"error\"}";
        }
        return "{\"msg\":\"success\"}";

    }

    @RequestMapping(value = "get-score-board", method = RequestMethod.POST)
    public @ResponseBody
    ScoreBoardDTO getResultByMatchId(@RequestBody Map<String, String> json) {
        int matchId = Integer.parseInt(json.get("matchId"));
        try {
            return scoreBoardService.getScoreBoardByMatchId(matchId);
        } catch (Exception e) {
            return new ScoreBoardDTO();
        }
    }

    @RequestMapping(value = "add-new-score-board", method = RequestMethod.POST)
    public @ResponseBody
    String addScoreBoard(@RequestBody Map<String, String> json) {
        int matchId = Integer.parseInt(json.get("matchId"));
        int scoreBoardId = Integer.parseInt(json.get("scoreBoardId"));
        String finalScore = json.get("finalScore");
        int totalMinute = Integer.parseInt(json.get("totalMinute"));
        String penaltyScore = json.get("penaltyScore");
        String note = json.get("note");

        ScoreBoardDTO scoreBoardDTO = new ScoreBoardDTO();
        MatchDTO matchDTO = new MatchDTO();
        matchDTO.setId(matchId);
        scoreBoardDTO.setMatchDTO(matchDTO);
        scoreBoardDTO.setFinalScore(finalScore);
        scoreBoardDTO.setNote(note);
        scoreBoardDTO.setPenaltyScore(penaltyScore);
        scoreBoardDTO.setTotalMinute(totalMinute);

        try {
            scoreBoardService.addScoreBoard(scoreBoardDTO);
        } catch (Exception e) {
            return "{\"msg\":\"error\"}";
        }
        return "{\"msg\":\"success\"}";
    }

    @RequestMapping(value = "update-score-board", method = RequestMethod.POST)
    public @ResponseBody
    String updateScoreBoard(@RequestBody Map<String, String> json) {
        int matchId = Integer.parseInt(json.get("matchId"));
        int scoreBoardId = Integer.parseInt(json.get("scoreBoardId"));
        String finalScore = json.get("finalScore");
        int totalMinute = Integer.parseInt(json.get("totalMinute"));
        String penaltyScore = json.get("penaltyScore");
        String note = json.get("note");

        ScoreBoardDTO scoreBoardDTO = new ScoreBoardDTO();
        MatchDTO matchDTO = new MatchDTO();
        matchDTO.setId(matchId);

        scoreBoardDTO.setId(scoreBoardId);
        scoreBoardDTO.setMatchDTO(matchDTO);
        scoreBoardDTO.setFinalScore(finalScore);
        scoreBoardDTO.setNote(note);
        scoreBoardDTO.setPenaltyScore(penaltyScore);
        scoreBoardDTO.setTotalMinute(totalMinute);

        try {
            scoreBoardService.updateScoreBoard(scoreBoardDTO);
        } catch (Exception e) {
            return "{\"msg\":\"error\"}";
        }
        return "{\"msg\":\"success\"}";
    }
}
