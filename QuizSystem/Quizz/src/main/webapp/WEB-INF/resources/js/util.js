/**
 * Utility functions
 *
 * Created: QuangNV
 */

function getFileName(input) {
    var fileInfo = $(input)[0].files[0];
    try{
        return fileInfo.name;
    }
    catch(Exeption){
        return "";
    }

}

function getFileSize(input) {
    var fileInfo = $(input)[0].files[0];
    var bytes = fileInfo.size;
    var BYTE = 1024;
    if (bytes < BYTE) {
        return bytes + "B";
    } else if (bytes < Math.pow(BYTE, 2)) {
        return Math.round(bytes / BYTE) + "KB";
    } else if (bytes < Math.pow(BYTE, 3)) {
        return Math.round(bytes / Math.pow(BYTE, 2)) + "MB";
    }
}
