public interface MediaAuthor{
void addAuthor(MediaFile mf);
Jpeg addAuthorToPicture(Jpeg jpeg);
}
public interface MediaPostProcessor extends MediaProcessor{
 Mp3 filterMusic(Mp3 mp3);
 Mpeg filterVideo(Mpeg mpeg);
 
}
public interface FinalProcessor extends MediaPostProcessor {
 String fileDestination;
 Boolean fileSaved;
 void playFile(File f);
 void attachFileToEnmail(File f);
 void sendEmail(Message m);
 Message[] readEmails(String server, String login, String
 pwd);
}
public interface Mediacuter extends MediaProcessor{
    void cutFile(File f, double start, double end);
}

public interface MediaConverter extends MediaProcessor{
    Mp3 convertToMp3(Wave wave);
    Avi convertToAvi(Mpeg mpeg);
}
public interface Medialoader extends MediaProcessor{
    Mp3 loadMusicFile(File f);
    Mpeg loadVideoFile(File f);
    Jpeg loadPicture(File f);
}

public interface Mediasaver extends MediaProcessor{
    void saveMusicFile(File f);
    void saveVideoFile(File f);
    void savePicture(File f);
}

public interface Mediaextracter extends MediaProcessor{
    Mp3 extractFromAvi(Avi avi);
    Mp3 extractFromMpeg(Mpeg mpeg);
}
