load swiss_roll_data

X = X_data';
plot3(X(1:1000,1),X(1:1000,2),X(1:1000,3),'xr');


D = L2_distance(X_data(:,1:1000), X_data(:,1:1000), 1); 



options.dims = 1:10;
[Y, R, E] = Isomap(D, 'k', 7, options); 
