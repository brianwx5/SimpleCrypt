import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class Sonnet18Test {

    @Test
    public void readFileTest() throws IOException {
        //Given
        String currentProjectDirectory = System.getProperty("user.dir");
        String fileName = currentProjectDirectory + "/Crypto/resource/sonnet18.txt";

        Sonnet18 sonnet18 = new Sonnet18(12);
        String expected = "Shall I compare thee to a summer’s day?\n" +
                "Thou art more lovely and more temperate:\n" +
                "Rough winds do shake the darling buds of May,\n" +
                "And summer’s lease hath all too short a date;\n" +
                "Sometime too hot the eye of heaven shines,\n" +
                "And often is his gold complexion dimm'd;\n" +
                "And every fair from fair sometime declines,\n" +
                "By chance or nature’s changing course untrimm'd;\n" +
                "But thy eternal summer shall not fade,\n" +
                "Nor lose possession of that fair thou ow’st;\n" +
                "Nor shall death brag thou wander’st in his shade,\n" +
                "When in eternal lines to time thou grow’st:\n" +
                "   So long as men can breathe or eyes can see,\n" +
                "   So long lives this, and this gives life to thee.";
        // when
        String actual = sonnet18.readFile(fileName);

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void writeFIleTest() throws IOException {
        //Given
        String currentProjectDirectory = System.getProperty("user.dir");
        String fileName = currentProjectDirectory + "/Crypto/resource/sonnet18.txt";
        String fileNameForWrite = currentProjectDirectory + "/Crypto/resource/sonnet18.enc";
        Sonnet18 sonnet18 = new Sonnet18(12);
        String sonnetencrpyt = sonnet18.readFile(fileName);
        sonnetencrpyt = sonnet18.caesar.rotateByCharacterPosition(sonnetencrpyt,12);
        sonnet18.writeFile(fileNameForWrite,sonnetencrpyt);
        System.out.println(sonnetencrpyt);

        //When
        String actual = sonnet18.readFile(fileNameForWrite);
        System.out.println(actual);

        //Then
        Assert.assertEquals(sonnetencrpyt,actual);
    }
}
