/*
 *  MimeTypes.java
 *
 *  Copyright (C) 2009  Francisco Gómez Carrasco
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 *  Report bugs or new features to: flikxxi@gmail.com
 *
 */
package com.softenido.cafecore.util;

import java.io.File;

/**
 *
 * @author franci
 */
public class MimeTypes
{
    public static final String APPLICATION_JAVASCRIPT       = "application/javascript";
    public static final String APPLICATION_MSWORD           = "application/msword";
    public static final String APPLICATION_OCTET_STREAM     = "application/octet-stream";
    public static final String APPLICATION_PDF              = "application/pdf";
    public static final String APPLICATION_POSTSCRIPT       = "application/postscript";
    public static final String APPLICATION_RTF              = "application/rtf";
    public static final String APPLICATION_X_COMPRESSED = "application/x-compressed";
    public static final String APPLICATION_X_DVI            = "application/x-dvi";
    public static final String APPLICATION_X_GTAR           = "application/x-gtar";
    public static final String APPLICATION_X_GZIP           = "application/x-gzip";
    public static final String APPLICATION_X_JAVASCRIPT     = "application/x-javascript";
    public static final String APPLICATION_X_OGG            = "application/x-ogg";
    public static final String APPLICATION_X_SH             = "application/x-sh";
    public static final String APPLICATION_X_SHOCKWAVE_FLASH= "application/x-shockwave-flash";
    public static final String APPLICATION_X_TAR            = "application/x-tar";
    public static final String APPLICATION_X_X509_CA_CERT   = "application/x-x509-ca-cert";
    public static final String APPLICATION_ZIP              = "application/zip";
    public static final String AUDIO_MPEG                   = "audio/mpeg";
    public static final String AUDIO_MPEG_URL               = "audio/mpeg-url";
    public static final String AUDIO_X_WAV                  = "audio/x-wav";
    public static final String IMAGE_BMP                    = "image/bmp";
    public static final String IMAGE_GIF                    = "image/gif";
    public static final String IMAGE_JPEG                   = "image/jpeg";
    public static final String IMAGE_PNG                    = "image/png";
    public static final String IMAGE_SVG_XML                = "image/svg+xml";
    public static final String IMAGE_TIFF                   = "image/tiff";
    public static final String IMAGE_X_ICON                 = "image/x-icon";
    public static final String TEXT_CSS                     = "text/css";
    public static final String TEXT_HTML                    = "text/html";
    public static final String TEXT_PLAIN                   = "text/plain";
    public static final String TEXT_RICHTEXT                = "text/richtext";
    public static final String TEXT_X_VCARD                 = "text/x-vcard";
    public static final String TEXT_XML                     = "text/xml";
    public static final String VIDEO_MP4                    = "video/mp4";
    public static final String VIDEO_MPEG                   = "video/mpeg";
    public static final String VIDEO_OGG                    = "video/ogg";
    public static final String VIDEO_QUICKTIME              = "video/quicktime";
    public static final String VIDEO_X_FLV                  = "video/x-flv";
    public static final String VIDEO_X_MS_ASF               = "video/x-ms-asf";
    public static final String VIDEO_X_MSVIDEO              = "video/x-msvideo";
    public static final String VIDEO_X_SGI_MOVIE            = "video/x-sgi-movie";
    
    public static final String MIME_DEFAULT_BINARY = APPLICATION_OCTET_STREAM;    

    /**
     *
     */
    public static final String[][] EXT_TYPES =
    {
        {"asc",  TEXT_PLAIN},
        {"avi",	 VIDEO_X_MSVIDEO},
        {"bmp",  IMAGE_BMP},
        {"class",APPLICATION_OCTET_STREAM},
        {"css",  TEXT_CSS},
        {"doc",  APPLICATION_MSWORD},
        {"exe",  APPLICATION_OCTET_STREAM},
        {"flv",  VIDEO_X_FLV},
        {"gif",  IMAGE_GIF},
        {"htm",  TEXT_HTML},
        {"html", TEXT_HTML},
        {"ico",  IMAGE_X_ICON},
        {"jpe",  IMAGE_JPEG},
        {"jpeg", IMAGE_JPEG},
        {"jpg",  IMAGE_JPEG},
        {"js",   APPLICATION_JAVASCRIPT},
        {"m3u",  AUDIO_MPEG_URL},
        {"mov",  VIDEO_QUICKTIME},
        {"mp3",  AUDIO_MPEG},
        {"mp4",  VIDEO_MP4},
        {"mpeg", VIDEO_MPEG},
        {"mpg",  VIDEO_MPEG},
        {"ogg",  APPLICATION_X_OGG},
        {"ogv", VIDEO_OGG},
        {"pdf", APPLICATION_PDF},
        {"png", IMAGE_PNG},
        {"svg",  IMAGE_SVG_XML},
        {"swf",  APPLICATION_X_SHOCKWAVE_FLASH},
        {"tgz",  APPLICATION_X_COMPRESSED},
        {"tif",  IMAGE_TIFF},
        {"tiff", IMAGE_TIFF},
        {"txt",  TEXT_PLAIN},
        {"xml",  TEXT_XML},
        {"zip", APPLICATION_ZIP},
//        {"zip",  APPLICATION_OCTET_STREAM},
    };

    public static String getMimeType(String fileName)
    {
        for(int i = 0; i<EXT_TYPES.length;i++)
        {
            String name = fileName.toLowerCase();
            if(name.endsWith("."+EXT_TYPES[i][0]))
            {
                return EXT_TYPES[i][1];
            }
        }
        return APPLICATION_OCTET_STREAM;
    }
    public static String getMimeType(File file)
    {
        return getMimeType(file.getName());
    }
}
