#Loop through a list of 5 folder names and create them under C:\TestFolders.

$folderNames = @("Folder1", "Folder2", "Folder3", "Folder4", "Folder5")

$basePath = "C:\TestFolders"
if (-not (Test-Path $basePath)) {
    New-Item -Path $basePath -ItemType Directory
}

foreach ($folderName in $folderNames) {
    $folderPath = Join-Path -Path $basePath -ChildPath $folderName
    if (-not (Test-Path $folderPath)) {
        New-Item -Path $folderPath -ItemType Directory
        Write-Host "Created folder: $folderPath"
    } else {
        Write-Host "Folder already exists: $folderPath"
    }
}
Pause