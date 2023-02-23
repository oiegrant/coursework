load 2moons.mat;
figure;
subplot(1,3,1);
plot(x(y==1,1),x(y==1,2),'ro'); hold on;
plot(x(y==-1,1),x(y==-1,2),'bx');

[coeff,score,latent] = pca(x);

subplot(1,3,2);
plot(score(y==1,1),zeros(sum(y==1)),'ro'); hold on;
plot(score(y==-1,1),zeros(sum(y==-1)),'bx');
title('PCA');

subplot(1,3,3);

score=lle(x',3,1)'; % try 3, 20, 6

plot(score(y==1,1),zeros(sum(y==1)),'ro'); hold on;
plot(score(y==-1,1),zeros(sum(y==-1)),'bx');
title('LLE');



