package com.yoon.eiheihei.dao;

import com.yoon.eiheihei.domain.EiVideo;
import com.yoon.eiheihei.domain.EiVideoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EiVideoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table eiheihei..ei_video
     *
     * @mbg.generated
     */
    long countByExample(EiVideoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table eiheihei..ei_video
     *
     * @mbg.generated
     */
    int deleteByExample(EiVideoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table eiheihei..ei_video
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table eiheihei..ei_video
     *
     * @mbg.generated
     */
    int insert(EiVideo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table eiheihei..ei_video
     *
     * @mbg.generated
     */
    int insertSelective(EiVideo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table eiheihei..ei_video
     *
     * @mbg.generated
     */
    List<EiVideo> selectByExample(EiVideoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table eiheihei..ei_video
     *
     * @mbg.generated
     */
    EiVideo selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table eiheihei..ei_video
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") EiVideo record, @Param("example") EiVideoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table eiheihei..ei_video
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") EiVideo record, @Param("example") EiVideoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table eiheihei..ei_video
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(EiVideo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table eiheihei..ei_video
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(EiVideo record);
}