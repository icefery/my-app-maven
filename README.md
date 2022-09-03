## 构建

#### 推送到 Nexus 仓库

- `pom.xml`

  ```xml
  <distributionManagement>
      <repository>
          <id>maven-custom</id>
          <url>http://nexus.dev.icefery.xyz/repository/maven-custom/</url>
      </repository>
  </distributionManagement>
  ```

- `~/.m2/settings.xml`

  ```xml
  <servers>
      <server>
          <id>maven-custom</id>
          <username>admin</username>
          <password>admin</password>
      </server>
  </servers>
  ```
