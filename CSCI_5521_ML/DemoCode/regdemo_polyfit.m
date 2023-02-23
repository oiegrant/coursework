%two dimensional data
load car_data;
x1=data(:,4); %weight
y=mpg;
figure;
X=[ones(size(x1)) x1]; % add bias term

plot(x1,y,'o')
hold on
b = regress(y,X) % Removes NaN data
x1fit = min(x1):100:max(x1);
pred = [ones(size(x1fit')) x1fit']*b;%get prediction
plot(x1fit,pred,'-')
xlabel('Weight')
ylabel('MPG')

%polynomial fitting
x2=x1.*x1;
X = [ones(size(x1)) x1 x2];
b = regress(y,X)
pred = X*b;
hold on
plot(x1,pred,'rx')
%b=(X'*X)^(-1)*X'*y
figure;
scatter3(x1,x2,y,'filled');
x1fit = min(x1):100:max(x1);
x2fit = min(x2):10000:max(x2);
hold on
[X1FIT,X2FIT] = meshgrid(x1fit,x2fit);
YFIT = b(1) + b(2)*X1FIT + b(3)*X2FIT;
mesh(X1FIT,X2FIT,YFIT)
xlabel('Weight')
ylabel('Weight^2')
zlabel('MPG')
view(50,10)










