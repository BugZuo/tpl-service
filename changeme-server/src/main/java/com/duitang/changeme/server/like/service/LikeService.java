package com.duitang.changeme.server.like.service;

import com.duitang.changeme.client.dto.LikeDTO;
import com.duitang.changeme.client.service.ILikeService;
import com.duitang.changeme.server.context.annotation.KarmaService;
import com.duitang.changeme.server.like.dao.LikeDAO;
import com.duitang.changeme.server.like.domain.LikeDO;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;

/**
 * Created by alex on 9/10/15.
 */
@KarmaService(value = "likeService")
public class LikeService implements ILikeService {
  @Resource
  private LikeDAO likeDAO;
  @Resource
  private ModelMapper modelMapper;
  private static final Logger logger = LoggerFactory.getLogger(LikeService.class);

  @Override
  public LikeDTO findOne() {
    LikeDTO res = null;
    LikeDO likeDO = likeDAO.findById(2);
    if (null != likeDO) {
      res = modelMapper.map(likeDO, LikeDTO.class);
    }
    logger.info("hello log");

    // update
    if (null != likeDO) {
      likeDAO.updateUserIdById(2, likeDO.getUserId() + 1);
      logger.info("like record {} updated userId", likeDO.getId());
    }
    return res;
  }
}
