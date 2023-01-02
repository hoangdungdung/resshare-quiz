TAG=$(shell git describe --tags --long)

build:
	mvn clean package -DskipTests
	unzip -q target/vn-wallet-proxy-1.0.jar -d target/java-app
	docker build --pull -t registry.truemoney.com.vn/tmvn/vn_wallet_proxy:$(TAG) .

push: build
	docker push registry.truemoney.com.vn/tmvn/vn_wallet_proxy:$(TAG)

deploy:
	@echo "\033[92mThis will deploy tag $(TAG)\033[0m"
	cd $(ANSIBLE_ROOT) && ansible-playbook -e version=$(TAG) -Dvv -i dev vn-wallet-proxy-deploy.yml 

version:
	@echo $(TAG)
