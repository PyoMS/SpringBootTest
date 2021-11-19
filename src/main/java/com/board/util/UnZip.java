package com.board.util;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.zip.Inflater;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * zip file decompressor
 * @author PMS
 * */
public class UnZip {
	private static final Logger logger = LoggerFactory.getLogger(UnZip.class);
	
	public static void unzipFile(Path sourceZip, Path targetDir) {
        try (ZipInputStream zis = new ZipInputStream(new FileInputStream(sourceZip.toFile()))) {

            // list files in zip
            ZipEntry zipEntry = zis.getNextEntry();
            while (zipEntry != null) {

                boolean isDirectory = false;
                if (zipEntry.getName().endsWith(File.separator)) {
                    isDirectory = true;
                }

                Path newPath = zipSlipProtect(zipEntry, targetDir);
                if (isDirectory) {
                    Files.createDirectories(newPath);
                } else {
                    if (newPath.getParent() != null) {
                        if (Files.notExists(newPath.getParent())) {
                            Files.createDirectories(newPath.getParent());
                        }
                    }
                    // copy files
                    Files.copy(zis, newPath, StandardCopyOption.REPLACE_EXISTING);
                }

                zipEntry = zis.getNextEntry();
            }
            zis.closeEntry();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	public static Path zipSlipProtect(ZipEntry zipEntry, Path targetDir)
            throws IOException {

        // test zip slip vulnerability
        Path targetDirResolved = targetDir.resolve(zipEntry.getName());

        // make sure normalized file still has targetDir as its prefix
        // else throws exception
        Path normalizePath = targetDirResolved.normalize();
        if (!normalizePath.startsWith(targetDir)) {
            throw new IOException("Bad zip entry: " + zipEntry.getName());
        }
        return normalizePath;
    }
	
	public static boolean ReadFile( String fname, StringBuffer inStr )
	{
		if( inStr == null )
		{
			inStr = new StringBuffer() ;
		}
		inStr.delete(0, inStr.length()) ;
		
		try {
			File fin = new File( fname ) ;
			long fLen = fin.length() ;
			FileReader frin = new FileReader( fin ) ;
			char[] fcont = new char[ (int) fLen ] ;

			fLen = frin.read( fcont, 0, (int) fLen ) ;
			inStr.append( fcont ) ;
			inStr.setLength( (int) fLen ) ;
			frin.close() ;
		} 
		catch( FileNotFoundException e ) 
		{
			logger.error(" *** ERROR : ReadFileContents(FileNotFoundException) *** : " + fname + e.toString());
			return false ;
		} 
		catch( IOException ex ) 
		{
			logger.error(ex.getMessage());
			return false ;
		}
		return true ;
	}
	
	/**
	 * byte array로 리턴하는 method
	 * @return byte[]*/
	public static byte[] unZip(byte[] data)
            throws Exception {
        Inflater decompressor = new Inflater();
        decompressor.setInput(data);

        ByteArrayOutputStream bos = new ByteArrayOutputStream(2048);

        byte[] buf = new byte[1024];
        int count = 0;
        while (!decompressor.finished()) {
            count = decompressor.inflate(buf);
            bos.write(buf, 0, count);
        }
        decompressor.end(); 
        bos.close();
        return bos.toByteArray();
    }
	
	public static String getString(byte[] data)
            throws Exception {

        Inflater decompressor = new Inflater();
        decompressor.setInput(data);

        ByteArrayOutputStream bos = new ByteArrayOutputStream(2048);

        byte[] buf = new byte[1024];
        int count = 0;
        while (!decompressor.finished()) {
            count = decompressor.inflate(buf);
            bos.write(buf, 0, count);
        }
        decompressor.end(); 
        bos.close();
        return new String(bos.toByteArray());
    }
	
}
