
## 构建镜像

```shell
docker build -t my-app-maven:0.0.1 -f ci/Dockerfile.multi-stage .
```

## 推送镜像

### 推送镜像到 GitHub Packages

```shell
export USERNAME=icefery
export GITHUB_TOKEN=

docker tag my-app-maven:0.0.1 ghcr.io/${USERNAME}/my-app-maven:0.0.1
echo ${GITHUB_TOKEN} | docker login ghcr.io -u ${USERNAME} --password-stdin
docker push ghcr.io/${USERNAME}/my-app-maven:0.0.1
```

## 发布 JAR 包

### 推送到 GitHub Packages

- `~/.m2/settings.xml`

  ```xml
  <?xml version="1.0" encoding="UTF-8"?>
  <settings>
      <servers>
          <server>
              <id>nexus-release</id>
              <username>admin</username>
              <password>admin</password>
          </server>
          <server>
              <id>github</id>
              <username>icefery</username>
              <password><!-- GITHUB_TOKEN --></password>
          </server>
      </servers>
  </settings>
  ```

- `pom.xml`

  ```xml
  <distributionManagement>
      <repository>
          <id>github</id>
          <url>https://maven.pkg.github.com/icefery/my-app-maven</url>
      </repository>
  </distributionManagement>
  ```

- `mvn deploy`
