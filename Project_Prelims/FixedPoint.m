clc
format long
%[1,2] 1,1.5 1.5,2
n = -1;
oldAns = -1;
newAns = 1;
arr = [];
while oldAns ~= newAns
    oldAns = newAns;
    newAns = round(((-log(oldAns)+4+(oldAns^2))/4), 10);
    arr = [arr;n+2 oldAns newAns];
 	n = n + 1;
end

disp(arr);