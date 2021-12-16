package com.kokochi.study.FilmProject.util;

import com.kokochi.study.FilmProject.domain.FileVO;
import com.kokochi.study.FilmProject.domain.MusicVO;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.imageio.ImageIO;
import javax.servlet.ServletContext;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

@Component("fileUtil")
@Log4j2
public class FileUtil {
    // 게시판 첨부파일을 저장하고 목록 리턴
/*    public List<BoardFileVO> uploadBoardFiles(MultipartHttpServletRequest request, String boardId, String storePath, Integer width, HashMap<String, BoardThumbVO> thumbMap) throws Exception {

        return fileList;
    }*/

    public MusicVO uploadMusic(MultipartHttpServletRequest request, String id) {
        Iterator<String> fileNames = request.getFileNames();
        FileVO fileVO = new FileVO();
        while (fileNames.hasNext()) {
            String filename = fileNames.next();
            MultipartFile multipartFile = request.getFile(filename);
            fileVO = uploadFile(request, multipartFile, id);
        }
        return fileVO.fileToMusic();
    }


    public FileVO uploadFile(MultipartHttpServletRequest request, MultipartFile multipartFile, String id) {
        FileVO fileVO = new FileVO();
        String uploadPath = request.getSession().getServletContext().getRealPath("/").concat("resources");
        String musicUploadPath = uploadPath + File.separator + "music";
        if (!multipartFile.isEmpty()){
            String originName = multipartFile.getOriginalFilename();
            String extension = originName.substring(originName.lastIndexOf(".") + 1).toLowerCase();
            fileVO.setId(id);
            fileVO.setOriginName(originName);
            fileVO.setExtension(extension);
            fileVO.setSize(multipartFile.getSize());

            File musicfile = new File(musicUploadPath, id+"."+extension);
            File saveFolder = new File(musicUploadPath);
            try {
                if(!saveFolder.exists()) {
                    saveFolder.mkdirs();
                }
                multipartFile.transferTo(musicfile);
            } catch (Exception e) {
                e.printStackTrace();
                log.error("파일 업로드 에러");
            }
        }
        return fileVO;
    }
}
