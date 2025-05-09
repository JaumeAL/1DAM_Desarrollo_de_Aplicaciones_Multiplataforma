$basePath = "C:\UsersTest"
if (-not (Test-Path $basePath)) {
    New-Item -Path $basePath -ItemType Directory
}

for ($i = 1; $i -le 5; $i++) {
    $username = Read-Host "Enter username $i"
    $folderPath = Join-Path $basePath $username
    New-Item -Path $folderPath -ItemType Directory -Force | Out-Null

    $info = @"
Username: $username
Date: $(Get-Date)
"@
    $info | Out-File -FilePath (Join-Path $folderPath "info.txt") -Encoding UTF8
}

Get-ChildItem -Path $basePath -Directory | Select-Object Name
