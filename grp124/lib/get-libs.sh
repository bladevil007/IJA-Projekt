#Download additional pictures and libs

echo "Downloading objects...."
cd lib
rm -rf  objects
wget www.stud.fit.vutbr.cz/~xdurca01/objects.zip
unzip objects
rm objects.zip
cd ..
