clc
pn = (1.5+2)/2;
%[1,2] 1,1.5 1.5,2

oldAns = -1;
newAns = pn;
n = 0;
i = 1;

format long
arr = [];

while (oldAns ~= newAns)
    oldAns = newAns;
    newAns = round(oldAns - (((oldAns - 2)^2 - log(oldAns))/(2*(oldAns - 2) - (1/oldAns))),10);
    arr = [arr; n+1 oldAns newAns];
    n = n + 1;
    i = i + 1;
end

disp(arr)