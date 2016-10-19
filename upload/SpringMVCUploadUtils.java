public class SpringMVCUploadUtils {
	 public String uploadPhoto(@RequestParam("file") MultipartFile file) throws Exception{
        if (!file.isEmpty()) {
            byte[] bytes = file.getBytes();
            
            String imgName = file.getOriginalFilename();
            String suffix = imgName.substring(imgName.lastIndexOf(".")+1,imgName.length());
            String randName = IdGen.uuid();
            String fileLocalPath = randName +"."+suffix;
            File fileSave = new File(fileLocalPath);
            
            BufferedOutputStream stream =
                    new BufferedOutputStream(new FileOutputStream(fileSave));
            stream.write(bytes);
            stream.close();
            return  fileLocalPath;
        } else {
            logger.error("You failed to upload");
            return "";
        }
    }
}