package cn.edu.lnpu.cns.service.impl;

import cn.edu.lnpu.cns.bean.Picture;
import cn.edu.lnpu.cns.mapper.PictureMapper;
import cn.edu.lnpu.cns.service.PictureService;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @author wangning113
 * @since 2018/4/9
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class PictureServiceImpl implements PictureService{

    private final Logger logger = LoggerFactory.getLogger(PictureServiceImpl.class);

    @Autowired
    private PictureMapper pictureMapper;

    @Override
    public Long addPicture(String picture) {
        return pictureMapper.insertOne(picture);
    }

    /**
     * 通过id删除图片
     *
     * @param id
     */
    @Override
    public int deletePictureById(Long id) {
        return pictureMapper.deletePictureById(id);
    }

    /**
     * 根据id更新图片
     *
     * @param picture1
     * @return
     */
    @Override
    public int updatePictureById(Picture picture1) {
        int i = 0;
        try{
           i =  pictureMapper.updatePictureById(picture1);
        }catch (Exception e){
            logger.error("----------------------更新图片异常--------------------：",e);
            throw new RuntimeException(e);
        }
        return i;
    }

    /**
     * 查询图片数量
     *
     * @param map
     * @return
     */
    @Override
    public long findPictureCount(Map<String, Object> map) {
        return pictureMapper.findPictureCount(map);
    }

    /**
     * 分页查询图片列表
     *
     * @param pageNum
     * @param pageSize
     * @param map
     * @return
     */
    @Override
    public List<Picture> findPictureLiatPage(int pageNum, int pageSize, Map<String, Object> map) {
        PageHelper.startPage(pageNum,pageSize);
        return pictureMapper.findPictureListPage(map);
    }
}
