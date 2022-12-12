using System.IO;

namespace FileManager.Infrastructrure
{
    /// <summary>
    /// для отображения дисков
    /// </summary>
    public class DrivePanel
    {
        public static DriveInfo[] DrivesList  => DriveInfo.GetDrives();  
    }
}
