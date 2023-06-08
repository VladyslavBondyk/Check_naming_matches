//No need to add any test here. 
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class AssetNameMatcher {


    public static void main(String[] args) {
        // Define the path to your asset folder
        String assetFolderPath = "path_to_local_folder"; 
        // it works with GDrive folder if its goes through ur computer *not a browser. Then u need to set the API
    
        // Define the list of names
        List<String> nameList = new ArrayList<>();
        nameList.add("name if 1st file");


        // Add more names to the list as needed
    
 // Find matching and unmatched assets in the folder
 List<File> matchedAssets = new ArrayList<>();
 List<File> unmatchedAssets = new ArrayList<>();
 findMatchingAssets(new File(assetFolderPath), nameList, matchedAssets, unmatchedAssets);

 // Print the matched assets
 System.out.println("Matched assets:");
 for (File asset : matchedAssets) {
     System.out.println(asset.getAbsolutePath());
 }

 // Print the unmatched assets
 System.out.println("Unmatched assets:");
 for (File asset : unmatchedAssets) {
     System.out.println(asset.getAbsolutePath());
 }

 // Check if all names were found
 boolean allNamesFound = (nameList.size() == matchedAssets.size());
 System.out.println("All names found: " + allNamesFound);
}

private static void findMatchingAssets(File directory, List<String> nameList,
                                    List<File> matchedAssets, List<File> unmatchedAssets) {
 File[] files = directory.listFiles();
 if (files != null) {
     for (File file : files) {
         if (file.isDirectory()) {
             // Recursively search subdirectories
             findMatchingAssets(file, nameList, matchedAssets, unmatchedAssets);
         } else {
             String fileName = file.getName();
             if (nameList.contains(fileName)) {
                 matchedAssets.add(file);
             } else {
                 unmatchedAssets.add(file);
             }
         }
     }
 }
}
}