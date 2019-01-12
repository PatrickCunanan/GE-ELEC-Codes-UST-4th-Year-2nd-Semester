clc
format long
%[1,2] 1,1.5 1.5,2
a = 1.4;
b = 1.8;
p = (a + b) / 2;
i = 1;
oldAns = - 1;
newAns = p;
arr = [];
while (oldAns ~= newAns)
	oldAns = newAns;
	newAns = round(((p - 2)^2 - log(p)),10);
	fa = round(((a - 2)^2 - log(a)),10);
	if (fa*newAns > 0)
		a = p;
    else
		b = p;
    end
	arr = [arr; i a b p newAns];
	i = i + 1;
	p = (a + b) / 2;
end

disp(arr)