package com.vitacard.rewardsvc.domain.dao.rewardcategory2;

import com.vitacard.rewardsvc.domain.entity.RewardCategory2;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RewardCategory2RowMapper implements RowMapper<RewardCategory2> {
    @Override
    public RewardCategory2 mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new RewardCategory2()
                .setId(rs.getString("id"))
                .setDescription(rs.getString("description"))
                .setCategory(rs.getString("category"))
                .setCategory1Id(rs.getString("reward_category_1_id"));
    }
}
