package com.vitacard.rewardsvc.domain.dao.rewardcategory1;

import com.vitacard.rewardsvc.domain.entity.RewardCategory1;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RewardCategory1RowMapper implements RowMapper<RewardCategory1> {
    @Override
    public RewardCategory1 mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new RewardCategory1()
                .setId(rs.getString("id"))
                .setDescription(rs.getString("description"))
                .setCategory(rs.getString("category"));
    }
}
