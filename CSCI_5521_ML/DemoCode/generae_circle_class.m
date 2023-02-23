clear;

M =1000;
N=2000;

X1 = 2 * (rand(M,2) - 0.5);
X1 = X1(diag(X1*X1')<=1,:);
X1 =[X1 sqrt(1-diag(X1*X1'))];
M = size(X1,1);
X2 = 4 * (rand(N,2) - 0.5);
X2 = X2(diag(X2*X2')<=4,:);
X2 =[X2 sqrt(4-diag(X2*X2'))];
N = size(X2,1);
class1 (1:M,1) = true;
class1 (M+1:N+M,1) = false;
class2 (1:M,1) = false;
class2 (M+1:N+M,1) = true;
X = [X1; X2];
for i=1:size(X,1)
    if (rand(1,1)>0.5)
     X(i,3) = -X(i,3);
    end
end

%X = [X(class1) X(class2)];

subplot(1,6,1);
plot3(X(class1,1),X(class1,2),X(class1,3),'ob'); hold on;
plot3(X(class2,1),X(class2,2),X(class2,3),'xr');

[coeff,score,latent] = pca(X);

P = score(:,1:2);

subplot(1,6,2);
plot(P(class1,1),P(class1,2),'ob'); hold on;
plot(P(class2,1),P(class2,2),'xr'); 
title(sprintf('PCA',i));

for i=3:6
    Y=lle(X',i,2)';
    subplot(1,6,i);
    plot(Y(class1,1),Y(class1,2),'ob'); hold on;
    plot(Y(class2,1),Y(class2,2),'xr'); 
    title(sprintf('LLE K=%d',i));
end

