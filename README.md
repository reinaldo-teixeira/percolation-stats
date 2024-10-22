## Percolation

Given a composite systems comprised of randomly distributed insulating and metallic materials: what fraction of the materials need to be metallic so that the composite system is an electrical conductor? Given a porous landscape with water on the surface (or oil below), under what conditions will the water be able to drain through to the bottom (or the oil to gush through to the surface)? Scientists have defined an abstract process known as percolation to model such situations.

## Solution
This is a exercise to validate the efficiency of WeightedQuickUnionUF class from QuickUnionUF class, where WeightedQuickUnionUF is O(N+M log N) and QuickUnionUF is O(Nˆ2)

### WeightedQuickUnionUF
```shell
mean                    = 1.06
stddev                  = 0.23868325657594203
95% confidence interval = [1.0132180817111154, 1.1067819182888847]
Time elapsed: 0.232s
```

### QuickUnionUF
```shell
mean                    = 1.03
stddev                  = 0.17144660799776548
95% confidence interval = [0.996396464832438, 1.0636035351675621]
Time elapsed: 19.949s
```

## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies

Meanwhile, the compiled output files will be generated in the `bin` folder by default.

> If you want to customize the folder structure, open `.vscode/settings.json` and update the related settings there.

## Dependency Management

The `JAVA PROJECTS` view allows you to manage your dependencies. More details can be found [here](https://github.com/microsoft/vscode-java-dependency#manage-dependencies).
