clc
format long
%[1,2] 1,1.5 1.5,2
n = 0;
i = 1;
p2 = 1.5;
p1 = 1;
arr = [];
while (p1 ~= p2)
	newValue = round(p1 - ((((p1 - 2)^2 - log(p1)) * (p1-p2)) / (((p1 - 2)^2 - log(p1)) - ((p2 - 2)^2 - log(p2)))), 10);
	p2 = p1;
	p1 = newValue;
    arr = [arr; n+1 p2 p1];
	n = n + 1;
	i = i + 1;
end

disp(arr)