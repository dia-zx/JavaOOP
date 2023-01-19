using System;
using System.IO;

namespace FileManager.Models
{
    public class FileTableList
    {
        public FileTableList(string Name, string Extention, string Size, DateTime dateTime, FileSystemInfo filesystemInfo)
        {
            _Name = Name;
            _Extention = Extention;
            _Size = Size;   
            _DateTime = dateTime;
            _FileSystemInfo = filesystemInfo;
        }

        public string Name =>_Name;
        public string Extention =>_Extention;
        public string Size =>_Size;
        public DateTime DateTime =>_DateTime; 
        public FileSystemInfo FileSystemInfo => _FileSystemInfo;  

        private string _Name;
        private string _Extention;
        private string _Size;
        private DateTime _DateTime;
        private FileSystemInfo _FileSystemInfo;
    }
}
