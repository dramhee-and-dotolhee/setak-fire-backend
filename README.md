## Install JAVA 17
- brew로 다운로드
`brew install openjdk@17`
- 환경변수 설정 
  - If you need to have openjdk@17 first in your PATH, run:
  `echo 'export PATH="/usr/local/opt/openjdk@17/bin:$PATH"' >> ~/.zshrc`
  - For compilers to find openjdk@17 you may need to set:
`echo 'export CPPFLAGS="-I/usr/local/opt/openjdk@17/include"' >> ~/.zshrc`
  - source ~/.zshrc
