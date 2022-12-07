docker build --platform linux/amd64 -t coals0329/hannah-education-backend .
docker push coals0329/hannah-education-backend

ssh -i ~/.ssh/hannah-education.pem ubuntu@3.35.249.142 "~/education-backend/education-backend-deploy.sh"
